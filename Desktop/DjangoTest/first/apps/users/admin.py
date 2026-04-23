from django.contrib.admin import register, ModelAdmin
from .models import CustomUser

@register(CustomUser)

class CustomUserAdmin(ModelAdmin):
    list_display=(
        "email",
        "full_name",
        "is_staff",
        "is_active",
    )

    search_fields=(
        "email",
        "full_name",
    )

    list_filter=(
        "is_staff",
        "is_active",
        "is_superuser",
    )


