from django.contrib import admin
from django.urls import path, include
from rest_framework.routers import DefaultRouter
from .views import CustomUserViewSet


router=DefaultRouter()

router.register(
    prefix="api",
    viewset=CustomUserViewSet,
    basename="users"
)


urlpatterns = [
    path("v1/", include(router.urls))
]
