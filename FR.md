Pour renommer vos fichiers avec jRename

# Utilisation générale #

## Format des noms de fichiers ##

  * tout en minuscule : Transforme chaque lettre en minuscule.
  * TOUT EN MAJUSCULE : Transforme chaque lettre en majuscule.
  * cHANGER lA cASE : Transforme les majuscules en minuscules et vice versa.
  * Capitales : Ajoute une majuscule au débuts des mots séparés par des blancs.
  * sans capitales : Retire les majuscules aux mots.
  * Rogner les blancs : Retire les blancs aux extrémités des noms de fichiers.
  * Autoriser les espaces : Autorise ou interdit la présence d'espaces dans les noms de fichiers.
  * Pas d'espace double : Transforme des espaces doubles en espaces simples.
  * Enlever les (#)'s : Supprime les parenthèses et leur contenu.
  * Enlever les (.) en trop : Enlève les points qui ne définissent pas l'extension du fichier.

## Increment ##

  * Début : Indice de démarrage de l'incrément.
  * Pas : Pas de l'incrément (différence entre deux valeurs successives).
  * Digits : Nombre minimum de caractères pour l'incrément. Un incrément débutant à 1, avec un pas de 1 sur 4 digits aura la séquence suivante 0001, 0002, 0003, ...

## Caractères interdits ##

  * Supprimer : Définit une liste de caractères interdits.
  * Remplacer : Définit une liste de caractères à remplacer par un autre caractère.

## Nom de sortie ##

Vous pouvez inclure des informations spécifiques pour chaque fichiers :

  * %j : Insère le jour du mois.
  * %m : Insère le mois courrant.
  * %a : Insère l'année courrante.
  * %i : Insère l'increment.
  * %n : Insère le nom original (sans l'extension)
  * %e : Insère l'extension.
  * %g0, %g1, ... : Insère les groupes capturés.

## Filtrage et capture ##

Utilisez des expressions régulières pour filtrer les fichiers. Seuls les fichiers qui vérifient l'expression régulière seront renommés. Les fichiers qui ne vérifient pas l'expression régulière sont marqués d'une croix rouge. Utilisez des parenthèses pour capturer des groupes.

# Expressions régulières #

## Filtrer les extensions ##

Une expression régulière peut permettre de ne retenir que les fichiers avec une certaine extension. Par exemple, pour ne renommer que des photos au format jpeg, il faut utiliser l'expression régulière qui ne retient que les extensions "jpg" et "JPG" :

```
.*\.(JPG||jpg)
```

## Capture d'informations ##

L'usage des parenthèses dans les expressions régulières permet d'extraire des informations du nom original pour les réutiliser dans le nom souhaité. Pour renommer des photos de vacances qui ont un nom attribué par votre appreil photo numérique :

```
IMAG0123.JPG
IMAG0124.JPG
IMAG0125.JPG
...
```

Vers un nom plus explicit :

```
0001 - Mon voyage au Canada 2009.jpg
0002 - Mon voyage au Canada 2009.jpg
0003 - Mon voyage au Canada 2009.jpg
...
```

Vous pouvez utiliser l'incrément dans le nom de sortie :

```
%c - Mon voyage au Canada %y.%e
```

Vous pouvez également réutiliser la numérotation de votre appareil photo pour conserver l'ordre de prise des photographies en utilisant l'expression régulière capturante suivante :

```
IMAG([0-9]+).JPG
```

Et utiliser le format de sortie suivant :

```
%g0 - Mon voyage au Canada %y.jpg
```