# The project was initialized with
npm create vite@latest . --template react

npm install

# Build
docker build -t employees-frontend-app .

# Run
docker run -p 8082:80 employees-frontend-app