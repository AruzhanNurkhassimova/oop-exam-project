from django.db.models import Model, CharField, TextField, ForeignKey, CASCADE
from django.conf import settings
from django.db import models
from django.core.exceptions import ValidationError
from typing import Any


class CommunityManager(models.Manager):

    def __obtain_community_instance(
        self,
        name: str,
        description: str,
        owner,
        visibility: str,
        **kwargs: dict[str, Any]
    ) -> "Community":

        if not name:
            raise ValidationError(
                message="This field is required",
                code="name_empty"
            )

        if not owner:
            raise ValidationError(
                message="Owner is required",
                code="owner_empty"
            )

        if not visibility:
            raise ValidationError(
                message="This field is required",
                code="visibility_empty"
            )

        new_community = self.model(
            name=name,
            description=description,
            owner=owner,
            visibility=visibility,
            **kwargs
        )

        return new_community

    def create_community(
        self,
        email: str,
        name: str,
        description: str,
        owner,
        visibility: str,
        **kwargs: dict[str, Any]
    ) -> "Community":

        new_community = self.__obtain_community_instance(
            name=name,
            description=description,
            owner=owner,
            visibility=visibility,
            **kwargs
        )

        new_community.save(using=self._db)
        return new_community


class Community(Model):

    NAME_MAX_LENGTH = 50

    VISIBILITY_MAX_LENGTH = 100

    VISIBILITY_CHOICES = [
        ("public", "Public"),
        ("private", "Private"),
    ]

    name = CharField(
        verbose_name="Community name",
        max_length=NAME_MAX_LENGTH,
    )

    description = TextField(
        verbose_name="Description",
        blank=True,
    )

    visibility = CharField(
        verbose_name="Visibility",
        max_length=VISIBILITY_MAX_LENGTH,
        choices=VISIBILITY_CHOICES,
        default="public",
    )

    owner = ForeignKey(
        settings.AUTH_USER_MODEL,
        on_delete=CASCADE,
        related_name="communities",
    )

    objects = CommunityManager()

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = "Community"