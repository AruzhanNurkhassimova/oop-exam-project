from rest_framework.serializers import Serializer, EmailField, CharField
from .models import CustomUser
from rest_framework.exceptions import ValidationError
from typing import Optional, Any


class UsersLoginSerializer(Serializer):

    email=EmailField(
        required = True,
        max_length = CustomUser.EMAIL_MAX_LENGTH
    )

    password=CharField(
        required = True,
        max_length = CustomUser.PASSWORD_MAX_LENGTH
    )

    class Meta:
        fields =(
        "email",
        "password",
        )

    def validate_email(self, value: str) -> str:
        """Validates the email field."""
        return value.lower()


    def validate(self, attrs: dict[str, Any]) -> dict[str, Any]:
        """Validate the input data"""
        email: str = attrs['email']
        password: str = attrs['password']

        user: Optional[CustomUser] = CustomUser.objects.filter(email=email).first()

        if not user:
            raise ValidationError(
                detail={
                    "email": [f"User with email '{email}' does not exist."]
                }
            )

        if not user.check_password(raw_password=password):
            raise ValidationError(
                detail={
                    "password": ["Incorrect password."]
                }
            )

        attrs['user'] = user
        return super().validate(attrs)
    

class ErrorSerializer(Serializer):
      """
      Serializer for HTTP 404 Method Not Allowed response.
      """
      detail  = CharField()
      class Meta:
        """Customization of the Serializer metadata."""

        fields = (
            "detail",
        )