from django.db import models
from django.contrib.auth import get_user_model

User = get_user_model()

class Post(models.Model):
    STATUS = [
        ("draft", "Draft"),
        ("publihed", "Published"),
        ("scheduled", "Scheduled"),
    ]
    title = models.CharField(max_length = 255)
    slug = models.SlugField(unique = True)
    body = models.TextField()
    author = models.ForeignKey(User, on_delete = models.CASCADE)
    status = models.CharField(max_length = 28, choices = STATUS, default = "draft")
    publish_at = models.DateTimeField(null = True, blank = True)
    created_at = models.DateTimeField(auto_now_add = True)

class Comment(models.Model):
    post = models.ForeignKey(Post, on_delete = models.CASCADE)
    author = models.ForeignKey(User, on_delete = models.CASCADE)
    body = models.TextField()
    created_at = models.DateTimeField(auto_now_add = True)