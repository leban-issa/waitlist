FROM node:14.16.0-alpine3.13
ADD . /usr/local/web
WORKDIR /usr/local/web
RUN npm install
EXPOSE 3000
CMD ["npm","start"]
