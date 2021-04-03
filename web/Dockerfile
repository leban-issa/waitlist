FROM node:14.16.0-alpine3.13
ADD . /usr/local/web
WORKDIR /usr/local/web
RUN npm install
EXPOSE 3000
CMD ["npm","start"]
# docker run --rm -it -v %cd%:/usr/local/web -p 3000:3000 ubuntu:18.04