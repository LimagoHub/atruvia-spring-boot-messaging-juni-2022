# microservice-workshop-kafka-juni-2022

Dieser Service ist der zentrale Service.
Er lauscht auf das Registrieren eines Antrags und persistiert ihn.
Danach wird ein "Antrag-persistiert-Event" publiziert.

Er lauscht außerdem auf das Eingehen von Scoring-Events (Normales Scoring und City-Scoring)
Er entscheidet über Annahme oder Ablehnung des Antrags und publiziert das Ergebnis 

