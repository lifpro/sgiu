# Utiliser l'image officielle OpenJDK 17 comme image de base
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copier le fichier JAR de votre application dans le conteneur
COPY target/registrationsvc.jar .

# Exposer le port sur lequel votre application écoute
EXPOSE 9095

# Définir la commande par défaut pour exécuter votre application
ENTRYPOINT ["java", "-jar", "registrationsvc.jar"]
