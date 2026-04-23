from django.contrib.admin import register, ModelAdmin

from .models import Community


@register(Community)
class CommunityAdmin(ModelAdmin):

    list_display = (
        "id",
        "name",
        "visibility",
        "owner",
    )

    search_fields = (
        "name",
    )

    list_filter = (
        "visibility",
    )