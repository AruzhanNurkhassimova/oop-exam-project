# Project modules
from decouple import config

# ----------------------------------------------
# Env id
#
ENV_POSSIBLE_OPTIONS = (
    "local",
    "prod",
)
ENV_ID = config("DJANGORLAR_ENV_ID", cast=str)
SECRET_KEY = "django-insecure-2^13pekzo(*h-zhr1_f0-lao__gfinerq=li==teq@fdohuz+d"