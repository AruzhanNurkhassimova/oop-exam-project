from typing import Any

from rest_framework.viewsets import ViewSet
from rest_framework.request import Request as DRFRequest
from rest_framework.response import Response as DRFResponse
from rest_framework.status import (
    HTTP_200_OK,
    HTTP_201_CREATED,
    HTTP_400_BAD_REQUEST,
    HTTP_404_NOT_FOUND,
)
from rest_framework.permissions import IsAuthenticated
from rest_framework.decorators import action

from drf_spectacular.utils import extend_schema, OpenApiResponse

from .models import Community
from .serializers import (
    CommunityCreateSerializer,
    CommunityDeleteSerializer,
    CommunitySerializer,
    ErrorSerializer,
)


class CommunityViewSet(ViewSet):

    permission_classes = [IsAuthenticated]

    @extend_schema(
        summary="Get all communities",
        responses={HTTP_200_OK: CommunitySerializer},
    )
    def list(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        communities = Community.objects.all()
        return DRFResponse(
            CommunitySerializer(communities, many=True).data,
            status=HTTP_200_OK,
        )

    @extend_schema(
        summary="Get community by id",
        responses={
            HTTP_200_OK: CommunitySerializer,
            HTTP_404_NOT_FOUND: ErrorSerializer,
        },
    )
    def retrieve(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        community = Community.objects.filter(id=kwargs["pk"]).first()

        if not community:
            return DRFResponse({"detail": "Not found"}, status=HTTP_404_NOT_FOUND)

        return DRFResponse(
            CommunitySerializer(community).data,
            status=HTTP_200_OK,
        )

    @extend_schema(
        summary="Get my communities",
        responses={HTTP_200_OK: CommunitySerializer},
    )
    @action(methods=["GET"], detail=False, url_path="my")
    def my(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        communities = Community.objects.filter(owner=request.user)
        return DRFResponse(
            CommunitySerializer(communities, many=True).data,
            status=HTTP_200_OK,
        )

    @extend_schema(
        summary="Create community",
        responses={
            HTTP_201_CREATED: OpenApiResponse(
                description="Community created",
                response=CommunitySerializer,
            ),
            HTTP_400_BAD_REQUEST: ErrorSerializer,
        },
    )
    def create(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        serializer = CommunityCreateSerializer(
            data=request.data,
            context={"request": request},
        )

        if not serializer.is_valid():
            return DRFResponse(serializer.errors, status=HTTP_400_BAD_REQUEST)

        community = serializer.save()

        return DRFResponse(
            CommunitySerializer(community).data,
            status=HTTP_201_CREATED,
        )

    @extend_schema(
        summary="Create simple community",
    )
    @action(methods=["POST"], detail=False, url_path="create-simple")
    def create_simple(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        name = request.data.get("name")

        if not name:
            return DRFResponse(
                {"detail": "Name required"},
                status=HTTP_400_BAD_REQUEST,
            )

        community = Community.objects.create(
            name=name,
            owner=request.user,
        )

        return DRFResponse(
            CommunitySerializer(community).data,
            status=HTTP_201_CREATED,
        )

    @extend_schema(
        summary="Test POST endpoint",
    )
    @action(methods=["POST"], detail=False, url_path="test")
    def test_post(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        return DRFResponse(
            {"detail": "Test POST works"},
            status=HTTP_200_OK,
        )

    @extend_schema(
        summary="Delete community",
        responses={
            HTTP_200_OK: OpenApiResponse(description="Deleted"),
            HTTP_404_NOT_FOUND: ErrorSerializer,
        },
    )
    def destroy(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        serializer = CommunityDeleteSerializer(
            data={"community_id": kwargs["pk"]},
            context={"request": request},
        )

        if not serializer.is_valid():
            return DRFResponse(serializer.errors, status=HTTP_400_BAD_REQUEST)

        serializer.delete()

        return DRFResponse({"detail": "Deleted"}, status=HTTP_200_OK)

    @extend_schema(
        summary="Delete by id",
    )
    @action(methods=["DELETE"], detail=False, url_path="delete-by-id")
    def delete_by_id(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        community_id = request.data.get("community_id")

        community = Community.objects.filter(
            id=community_id,
            owner=request.user,
        ).first()

        if not community:
            return DRFResponse(
                {"detail": "Not found"},
                status=HTTP_404_NOT_FOUND,
            )

        community.delete()

        return DRFResponse({"detail": "Deleted"}, status=HTTP_200_OK)

    @extend_schema(
        summary="Delete all my communities",
    )
    @action(methods=["DELETE"], detail=False, url_path="delete-all")
    def delete_all(self, request: DRFRequest, *args, **kwargs) -> DRFResponse:
        Community.objects.filter(owner=request.user).delete()

        return DRFResponse(
            {"detail": "All deleted"},
            status=HTTP_200_OK,
        )