# Semestrální práce
* MVC hra
* výběr z vlastností
  * obsahuje vzory: MVC, Strategy, Proxy, State, Visitor, Observer, Command, Memento, Abstract factory
  * změna síly střely (force)
  * úhlu kanónu (angle)
  * gravitace (gravity)
  * počítání score
  * možnost vystřelit více střel najednou (State)
  * ovládání modelu pomocí commandů (vzor Command)
  * krok-zpět (Memento&Command)
  * 2 strategie pohybu střely (Strategy)
* v projektu bude alespoň 5 unit testů (test cases) v alespoň 2 test suitech a bude použito mockování
* ukázka: [video](https://gitlab.fit.cvut.cz/MI-ADP/mi-adp/blob/master/media/tutorials/mvc-app-video.avi.zip)
* Java template: thisrepo
* C++ QT template: [mvcgame-qt.zip](https://gitlab.fit.cvut.cz/MI-ADP/mi-adp/blob/master/media/tutorials/mvc-shooter-qt.zip)
* vypracování: individuálně
* odevzdání: osobně na posledním cvičení

> Následující požadavky slouží jako kontrola pro studenta, aby
> věděl, že je na dobré cestě práci dokončit včas. Tzn. že požadavky
> nejsou na cvičeních explicitně kontrolovány

#### Požadavky na stav semestrální práce po 3. cvičení
* model nezávislý na view a controlleru (tzn na grafice, swingu)
  * jinými slovy, model musí být testovatelný, spustitelný i bez view a controlleru
* správný návrh hierarchie tříd (entit) v modelu (příklad: viz UML diagram z 1. cvičení)
  * třída Model neobsahuje herní logiku, logika je rozmístěna do příslušných tříd (missile.move() etc)
  * třída Model tedy pouze drží reference na ostatní herní objekty a slouží jako fasáda
  * (příklad: viz UML diagram z 1. cvičení)
* MVC včetně vzoru Observer použitého pro notifikaci Model =&gt; View
* návrhový vzor Visitor při vykreslování entit (model je nezávislý na View, takže entity neznají metody grafické knihovny)

#### Požadavky na stav semestrální práce po 4. cvičení
Aplikace bude obsahovat použité následující návrhové vzory. Připojuji i příklady, jak je použít.
* Strategy
  * Missile bude mít 2 strategie pohybu: simple a realistic. Simple je základní šikmý vrh (tak jak bylo do teď implementováno), realistická simuluje balistickou křivku (matematicky si můžete výpočet zjednodušit jak chcete)
* State
  * Cannon bude mít dva stavy: single shooting mode a double shooting mode (uživatel např. přehazuje stistkem tlačítka, nebo se stavy mohou automaticky střídat samy). V double shooting modu vystřelí kanon najednou vždy 2 střely, s určitým rozptylem
* AbstractFactory
  * při startu aplikace se určí (buď hard-coded proměnnou, nebo command-line-argumentem), zda se hra pustí v simple nebo realistic módu
  * v simple mode bude factory vytvářet simple missile (viz výše) a simple enemy, kde simple enemy nemění svou pozici
  * v realistic mode bude factory vytvářet realistic missile (viz výše) a realistic enemy, kde realist
* Proxy
  * přístup k modelu ze zbytku aplikace bude kontrolován pomocí vzoru Proxy

#### Požadavky na stav semestrální práce po 5. cvičení
Aplikace bude obsahovat použité následující návrhové vzory. Připojuji i příklady, jak je použít.

* Memento na ukládání stavu modelu
  * model bude schopen vytvářet Mementa o stavu hry
  * kromě modelu nebude mít nikdo možnost Mementa upravit! (zničit uložený stav)
* Command
  * Controller bude commandy vytvářet
  * Při vytvoření commandu se vytvoří memento o aktuálním stavu hry
  * Model na tik hodin zpracuje dosud nezpracované commandy
  * Existuje command pro krok-zpět, který vezme memento předcházejícího commandu a pomocí něj vrátí hru do předchozího stavu
* Testy
  * v projektu bude alespoň 5 unit testů (test cases) v alespoň 2 test suitech a bude použito mockování

