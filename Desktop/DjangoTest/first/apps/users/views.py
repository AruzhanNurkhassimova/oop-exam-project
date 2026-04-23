from django.shortcuts import render
from rest_framework.viewsets import ViewSet
from rest_framework.request import Request as DRFRequest
from typing import Any
from rest_framework.response import Response as DRFResponse
from .serializers import UsersLoginSerializer, ErrorSerializer
from rest_framework_simplejwt.tokens import RefreshToken
from rest_framework.status import HTTP_200_OK, HTTP_404_NOT_FOUND
from rest_framework.decorators import action
from rest_framework.permissions import AllowAny
from drf_spectacular.utils import extend_schema, OpenApiResponse



class CustomUserViewSet(ViewSet):

    serializer_class = UsersLoginSerializer

    @extend_schema(
        summary="Post User Login",
        responses={
            HTTP_200_OK: OpenApiResponse(
                description="Successfully logined",
                response=UsersLoginSerializer,
            ),
            HTTP_404_NOT_FOUND: OpenApiResponse(
                description="User with this email or password gdoes not exist",
                response=ErrorSerializer,
            ),
        }
    )
    @action(
        methods=["POST", ],  
        detail=False,
        url_path="login",
        url_name="login",
        permission_classes=[AllowAny,]
    )
    def login(
        self,
        request,
        *args: tuple[Any, ...],
        **kwargs: dict[str, Any]
    ) -> DRFResponse: 
        
        serializer = self.serializer_class(data=request.data)

        serializer.is_valid(
            raise_exception=True
        )

        user = serializer.validated_data.pop("user")

        refresh_token=RefreshToken.for_user(user)

        access_token=str(refresh_token.access_token)

        return DRFResponse(
            data={
                "id": user.id,
                "full_name": user.full_name,
                "access_token": access_token,
                "refresh_token": str(refresh_token),
            }, status=HTTP_200_OK
        )
    


    










