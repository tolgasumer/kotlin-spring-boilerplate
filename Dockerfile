FROM ubuntu:latest
LABEL authors="tolga"

ENTRYPOINT ["top", "-b"]