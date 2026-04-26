from django.urls import re_path
from .consumers import CommentRouter

websocket_urlpatterns = [
    re_path(r"ws/posts//(?P<slug>[^/]+)/comments/", CommentRouter.as_asgi()),
]