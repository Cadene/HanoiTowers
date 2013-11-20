MiniProjet de LI311


Que contient-il ?
Ce projet Java sous Eclipse contient quatre dossiers :- bin contient les fichiers compilés,- src contient les fichiers sources,- data contient les fichiers générés par notre programme,- doc contient le sujet et les réponses aux questions.



Comment le compiler et l’executer ?Afin de compiler et d'executer, deux possibilités :- avec Eclipse :  ouvrir Eclipse  selectionner votre Workspace  importer (File / Import...)    selectionner "General / Existing Projects into Workspace", puis Next    selectionner en root directory le dossier contenant notre dossier projet (ex: Téléchargements), puis Finish  compiler et executer (Run)- avec Terminal :  cd <directory>/LI311_MiniProjet_CadeneFieux  javac -cp ./src/BioInfo/*.java -d ./bin/BioInfo/