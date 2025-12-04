# Jour 04 – Fait une revue de la solution

> **Fragment de mémoire – 2023 · Jour 4**  
> Je me rappelle être resté longtemps devant ce code.  
> Pas pour le changer. Juste pour comprendre ce qu’il faisait vraiment.  
> Les tests étaient là, mais ils ne racontaient pas l’histoire.  
> Il a essayé de les réécrire pour capturer le comportement...  
> pas les détails d’implémentation.  
> ...  
> *Quelque part à ce moment-là, j’ai compris que relire du code, c’est aussi relire des idées.*

Pour ce quatrième jour du voyage, nous revisitons [un souvenir de l’édition 2023](https://github.com/advent-of-craft/2023/blob/main/docs/exercise/day04/challenge.md) où l’objectif n’était pas de “faire passer les tests”, mais de **comprendre et exprimer le comportement**.

Cette fois, ce n’est pas toi qui fais le kata et soumets la solution.  

**Tu es le ou la reviewer.**

---

## Défi — Relire la solution proposée comme une vraie PR

L’activation du jour est simple à décrire, mais riche en nuances :

> Regarde la **solution de référence** de cet exercice  
> comme si c’était une pull request d’un·e collègue,  
> et écris une revue de code réfléchie.

Essaie de porter attention non seulement à *ce que* fait le code, mais aussi à *la façon dont* tu donnes ton feedback.

---

## Zone de jeu

Choisis la stack que tu veux utiliser comme **stack principale** cette année et ouvre la solution proposée du souvenir du Jour 4 de 2023 :

- Solution proposée (celle que tu vas relire aujourd’hui) :  
  `memories/2023/solution/<your-stack>/day04`

Tu peux lancer les tests si tu veux, mais l’accent aujourd’hui est mis sur le **fait de lire et de revoir**, pas sur “tout changer”.

Note tes commentaires directement dans le code sous forme de commentaires, et écris tes observations globales dans un fichier de revue ou dans ton fichier de journey.

Laisse ta revue raconter l’histoire ➰💬

---

## Partage avec la communauté

Poste tes notes de revue ou tes principaux enseignements sur Discord et récolte les retours de la communauté. N’hésite pas à donner toi aussi un feedback respectueux sur les revues des autres.

Si tu veux rendre ta revue publique, ajoute ton fichier dans :  
- le dossier `community/solutions/dayNN/` en copiant le template situé ici :  
- `community/solutions/TEMPLATE-[replace_with_your_name].md`  
puis ouvre une pull request (en référant ton fork ou ta propre pull request).

Utilise le fichier `journey/your-name.md` et écris une entrée pour aujourd’hui :

- Qu’est-ce que ça m’a fait de relire une solution existante plutôt que d’écrire la mienne ?  
- Quel type de commentaires ai-je écrit naturellement (questions, suggestions, pinaillage, félicitations) ?  
- Qu’est-ce que cet exercice m’a appris sur **ma propre posture de revue** ?

![snippet of the day](img/day04.png)

---

## Une approche suggérée

### Si tu as besoin d’un point de départ

**Étape 1 – Commencer par les tests**

- Quel est le **comportement principal** testé ?  
- Comment expliquerais-tu cet exercice en **une ou deux phrases** à un·e autre dev ?

**Étape 2 – L’implémentation avec des yeux de reviewer**

- Formule tes pensées comme de vrais commentaires de revue :
  - Questions → « Que penserais-tu de… ? », « Pourquoi ce choix ? »
  - Suggestions → « Peut-être extraire… », « Tu pourrais renommer en… »
  - Félicitations → « J’aime bien comment… », « Bonne idée d’utiliser… »

**Étape 3 – Te relire toi-même**

- Relis tes propres commentaires :
  - Est-ce que j’ai mis assez d’informations ? Trop ?  
  - Quelle est ma posture ? (plutôt critique, plutôt encourageante, plutôt redesign ?)  
  - Est-ce que **j’aimerais** recevoir ce feedback de cette manière ?

### Capture ton voyage

Dans `journey/your-name.md`, ajoute une courte entrée pour aujourd’hui :

- Une phrase qui décrit le **comportement** que tu as vu dans les tests.  
- 2 à 3 commentaires de revue dont tu es **fier ou fière** (questions, suggestions, félicitations).  
- 1 chose que tu as remarquée sur **ta propre posture de revue** (est-ce que tu pinailles sur les détails, tu félicites, tu redesignes tout, etc.).
