#!/bin/sh

echo "Waiting for Redis..."

# Wait for Redis
until nc -z redis 6379; do
  sleep 1
done

echo "Redis is up!"

# Run migrations
python manage.py migrate

# Collect static files
python manage.py collectstatic --noinput

# Compile translations
python manage.py compilemessages

# Seed DB if needed
if [ "$BLOG_SEED_DB" = "true" ]; then
  echo "Seeding database..."
  python manage.py seed_db
fi

# Run command (IMPORTANT)
exec "$@"