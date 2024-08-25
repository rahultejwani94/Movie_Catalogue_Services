java brains microservices project contains following 3 microservices
1: movie-catalogue service
2: movie-info service
3: ratings-data service

movie-catalogue-service
input: user-id
output: list of movies with ratings


movie-info-service
input: movie-id
output: list of movies with details

ratings-data-service
input: user-id
output: movie-id and ratings

flow:
1: movie-catalogue-service will be called by the client which will give movie details watched by the user

2: movie-catalogue-service will internally call ratings-data service and movie-info service
