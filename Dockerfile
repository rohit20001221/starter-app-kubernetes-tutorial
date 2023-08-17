FROM python:3-alpine

WORKDIR /app

COPY . .

RUN pip install -r requirements.txt

ENV PORT 80

CMD ["python", "app.py"]