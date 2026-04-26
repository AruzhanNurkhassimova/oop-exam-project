from celery import shared_task
from .models import Notification
from apps.blog.models import Comment

@shared_task(autoretry_for = (Exception,), retry_backoff = True, max_retries = 3)
def process_new_comment(comment_id):
    comment = Comment.objects.get(id = comment_id)
    Notification.objects.create(
        recipient = comment.post.author,
        comment = comment
    )