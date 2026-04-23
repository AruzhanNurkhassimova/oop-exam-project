from django.db.models import Model, EmailField, CharField, BooleanField
from django.contrib.auth.models import AbstractBaseUser, PermissionsMixin, BaseUserManager
from typing import Any 
from django.core.exceptions import ValidationError


class CustomUserManager(BaseUserManager):
    def __obtain_user_instance(
        self,
        email: str,
        full_name: str,
        password: str,
        **kwargs: dict[str, Any]
    ) -> "CustomUser": 
        if not email:
            raise ValidationError(
                message = "This field is required",
                code = "email_empty"
            )
        
        if not full_name: 
            raise ValidationError(
                message = "This field is required",
                code = "full_name_empty"
            )
        
        if not password:
            raise ValidationError(
                message = "This field is required",
                code = "password_empty"
            )
        

        new_user = self.model(
            email=self.normalize_email(email), 
            full_name=full_name,
            password=password,
            **kwargs
        )
        return new_user
    
    def create_user(
        self,
        email: str,
        full_name: str,
        password: str,
        **kwargs: dict[str, Any]
    ) -> "CustomUser": 
        
        new_user = self.__obtain_user_instance(
            email=email,
            full_name=full_name,
            password=password,
            **kwargs
        )

        new_user.set_password(password)
        new_user.save(using = self._db)
        return new_user
    

    def create_superuser(
        self,
        email: str,
        full_name: str,
        password: str,
        **kwargs: dict[str, Any]
    ) -> "CustomUser":
        
        new_user = self.__obtain_user_instance(
            email=email,
            password=password,
            full_name=full_name,
            is_staff=True,
            is_superuser=True,
            **kwargs
        )


        new_user.set_password(password)
        new_user.save(using = self._db)
        return new_user


class CustomUser(AbstractBaseUser, PermissionsMixin):

    EMAIL_MAX_LENGTH = 200
    FULL_NAME_MAX_LENGTH = 200
    PASSWORD_MAX_LENGTH = 100

    email = EmailField(
        verbose_name="Email Address",
        max_length = EMAIL_MAX_LENGTH,
        unique = True,
    )

    full_name = CharField(
        verbose_name="Full name",
        max_length = FULL_NAME_MAX_LENGTH,
    )

    password = CharField(
        verbose_name= "Password",
        max_length = PASSWORD_MAX_LENGTH
    )

    is_staff = BooleanField(
        verbose_name = "Staff",
        default = False
    )

    is_active = BooleanField(
        verbose_name = "Active Status",
        default = True
    )


    REQUIRED_FIELDS = ["full_name"]
    
    USERNAME_FIELD = "email"

    objects = CustomUserManager()

    class Meta:
        verbose_name = "Custom User"
