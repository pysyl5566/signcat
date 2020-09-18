FROM registry.cn-hangzhou.aliyuncs.com/devcloud_base_image/openjdk:8

ARG APP_NAME
ENV APP_NAME=${APP_NAME}

COPY ./target/${APP_NAME}.jar /home/admin/${APP_NAME}.jar
COPY ./start.sh /home/admin/start.sh

RUN chmod +x /home/admin/*.sh

WORKDIR /home/admin

ENTRYPOINT ["/home/admin/start.sh"]