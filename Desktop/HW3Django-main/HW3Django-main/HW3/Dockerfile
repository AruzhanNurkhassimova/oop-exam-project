FROM python:3.12-slim

# Prevent python from writing .pyc files
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

# Set work directory
WORKDIR /app

# Install system deps
RUN apt-get update && apt-get install -y gettext && rm -rf /var/lib/apt/lists/*
RUN apt-get update && apt-get install -y netcat-openbsd gettext &&rm -rf /var/lib/apt/lists/*
# Create non-root user
RUN useradd -m appuser
RUN mkdir -p /app/static
RUN chmod -R 777 /app/static
# Copy project
COPY . /app
COPY . .

# Install dependencies
RUN pip install --upgrade pip
RUN pip install -r requirements/local.txt

RUN chmod +x /app/scripts/entrypoint.sh

# Change ownership
RUN chown -R appuser:appuser /app

# Switch to non-root user
USER appuser

# Entrypoint
ENTRYPOINT ["sh", "/app/scripts/entrypoint.sh"]