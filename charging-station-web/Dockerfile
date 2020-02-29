# base image
FROM node:12.2.0-alpine

# set working directory
WORKDIR /app

COPY . .

RUN npm install --silent
RUN npm install react-scripts@3.3.1 -g --silent

# start app
CMD ["npm", "start"]