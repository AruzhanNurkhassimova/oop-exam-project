from django.contrib import admin
from django.urls import path, include
from rest_framework.routers import DefaultRouter

from .views import CommunityViewSet


router = DefaultRouter()

router.register(
    prefix="communities",
    viewset=CommunityViewSet,
    basename="communities",
)


urlpatterns = [
    path("v1/", include(router.urls)),
]