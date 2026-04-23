from rest_framework.serializers import Serializer, CharField
from rest_framework.exceptions import ValidationError
from typing import Optional, Any

from .models import Community


class CommunityCreateSerializer(Serializer):

    name = CharField(
        required=True,
        max_length=Community.NAME_MAX_LENGTH,
    )

    description = CharField(
        required=False,
        allow_blank=True,
    )

    visibility = CharField(
        required=False,
    )

    class Meta:
        fields = (
            "name",
            "description",
            "visibility",
        )

    def validate(self, attrs: dict[str, Any]) -> dict[str, Any]:
        request = self.context["request"]

        visibility = attrs.get("visibility", "public")

        if visibility not in ["public", "private"]:
            raise ValidationError(
                detail={
                    "visibility": ["Invalid choice."]
                }
            )

        attrs["owner"] = request.user
        attrs["visibility"] = visibility

        return super().validate(attrs)

    def create(self, validated_data: dict[str, Any]) -> Community:
        return Community.objects.create(**validated_data)


class CommunitySerializer(Serializer):

    id = CharField()
    name = CharField()
    description = CharField()
    visibility = CharField()
    owner = CharField(source="owner.email")

    class Meta:
        fields = (
            "id",
            "name",
            "description",
            "visibility",
            "owner",
        )


class CommunityDeleteSerializer(Serializer):

    community_id = CharField(
        required=True,
    )

    class Meta:
        fields = (
            "community_id",
        )

    def validate(self, attrs: dict[str, Any]) -> dict[str, Any]:
        request = self.context["request"]
        community_id = attrs["community_id"]

        community: Optional[Community] = Community.objects.filter(
            id=community_id,
            owner=request.user,
        ).first()

        if not community:
            raise ValidationError(
                detail={
                    "community": ["Not found or not owner."]
                }
            )

        attrs["community"] = community

        return super().validate(attrs)

    def delete(self) -> None:
        community = self.validated_data["community"]
        community.delete()


class ErrorSerializer(Serializer):

    detail = CharField()

    class Meta:
        fields = (
            "detail",
        )