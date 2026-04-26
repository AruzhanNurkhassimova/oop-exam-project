from django.db import models
from django.contrib.auth import get_user_model
from apps.blog.models import Comment

User = get_user_model()

class Notification(models.Model):
    recipient = models.ForeignKey(User, on_delete = models.CASCADE)
    comment = models.ForeignKey(Comment, on_delete = models.CASCADE)
    is_read = models.BooleanField(default = False)
    created_at = models.DateTimeField(auto_now_add = True)