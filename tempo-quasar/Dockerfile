FROM node:20.11.0 AS build

FROM build as config
WORKDIR /app
COPY package.json package.json
COPY package-lock.json package-lock.json
RUN npm install --quiet
COPY . .
RUN npm i -g @quasar/cli
RUN npm update
RUN quasar build

FROM nginx:alpine
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY --from=config /app/dist/spa .
RUN rm /etc/nginx/conf.d/default.conf
COPY --from=config /app/default.conf /etc/nginx/conf.d/default.conf

ENTRYPOINT ["nginx", "-g", "daemon off;"]
