# Model-View-Controller (MVC) Tervezési Mintája

## Bevezetés:

Az MVC egy olyan tervezési minta, amely elválasztja az alkalmazás belső reprezentációját (model), a felhasználói felületet (view) és a felhasználói interakciókat kezelő vezérlőt. Ez a szétválasztás javítja a kód modularitását, újrahasznosíthatóságát és karbantarthatóságát.

## Komponensek:

### Model:
Adataink és üzleti logikánk helye.
Nem függ a felhasználói felülettől vagy a vezérlőtől.
Értesíti a nézeteket és vezérlőket az adatok változásáról.

### View:
Felhasználói felület megjelenítése.
Passzívan észleli a model változásait, és frissíti magát ennek megfelelően.
Nem tartalmaz üzleti logikát.

### Controller:
Felhasználói interakciókat kezeli.
Frissíti a modelt és a nézetet az interakciók alapján.
Közvetítő a model és a nézet között.

### Működés:
A felhasználói interakció egy vezérlőt érint.
A vezérlő frissíti a modellt.
A model értesíti a nézeteket az adatok változásáról.
A nézetek lekérdezik a friss adatokat a modeltől és frissítik magukat.

## További Tervezési Minták:
1. Singleton Tervezési Minta:
   Célja biztosítani, hogy egy osztályból csak egy példány létezzen. Pl: adatbázis kapcsolatkezelés, naplózás.
2. Factory Method Tervezési Minta:
   Célja az, hogy hozzon létre egy interfészt az objektum létrehozásához, de az osztályok a leszármazottakra bízva a példányosítást. Pl: GUI komponensek létrehozása.
3. Observer Tervezési Minta:
   Az a célja, hogy definiáljon egy egy-több kapcsolatot a tárgyak között, így ha egy objektum megváltozik, az összes annak függősége is értesül. Pl: eseménykezelés, publikálás-előfizetés rendszerek.
4. Strategy Tervezési Minta:
    Célja a különböző algoritmusokat definiál egy családban, és kicserélhetővé teszi azokat az alkalmazás futása közben. Pl: Sorrendezési algoritmusok cseréje.
5. Decorator Tervezési Minta:
   Célja a dinamikus funkcionalitás hozzáadása egy objektumhoz anélkül, hogy megváltoztatnánk annak struktúráját. Pl: Grafikus felhasználói felület stílusok vagy bővítmények hozzáadása.
6. Adapter Tervezési Minta:
   Célja, a két inkompatibilis rendszer közötti interfész illesztése. Pl: régi adatforrások használata új rendszerben.
7. Command Tervezési Minta:
   Az a céja, hogy kérést csomagol egy objektumba, így paraméterezhető, sorban állítható vagy naplózható. Pl: Menürendszer parancsok kezelése.
8. Proxy Tervezési Minta:
   Célja, hogy hozzáférést kontrollál egy objektumhoz, létrehozva egy közvetítő objektumot. Pl: Hálózati proxy a távoli erőforrásokhoz.
9. State Tervezési Minta:
   Célja, hogy egy objektum viselkedését attól függően változtassa meg, hogy belső állapota hogyan változik. Pl: Játékállapotok kezelése. 
10. Builder Tervezési Minta:
    Segít egy összetett objektum létrehozásában lépésről lépésre. Pl: Konfigurálható objektumok vagy összetett dokumentumok építése. 
11. Chain of Responsibility Tervezési Minta:
    Lehetővé teszi, hogy több objektum kezelje a kérést anélkül, hogy pontosan tudnánk, melyik fogja kezelni. Pl: Eseménykezelési láncok. 
12. Visitor Tervezési Minta:
    Célja, hogy egy új műveletet adjon hozzá egy objektum hierarchiához anélkül, hogy módosítanánk az osztályokat. Pl: Különböző formátumú dokumentumok exportálása. 
13. Composite Tervezési Minta:
    Lehetővé tesz egy összetett objektum kezelését úgy, mintha az egyedi elemek lennének. Pl: Grafikus elemek csoportosítása.
14. Template Method Tervezési Minta:
    Meghatározza egy algoritmus vázát, de a részleteket az leszármazottakra bízza. Pl: Osztályok közötti hasonló működés kialakítása. 
15. Flyweight Tervezési Minta:
    Célja, hogy több hasonló objektumnak osszák meg a részleteit, így csökkentve a memóriaigényt. Pl: Szövegkarakterek újrafelhasználása egy szöveg szerkesztőben.  
16. Interpreter Tervezési Minta:
    Egy nyelvet értelmez, és lehetővé teszi, hogy az alkalmazásban definiált nyelvi elemeket használjunk. Pl: Matematikai kifejezések kiértékelése. 
17. Mediator Tervezési Minta:
    Célja, hogy közvetítse a kommunikációt több objektum között, így azok nem közvetlenül egymással kommunikálnak. Pl: Chat alkalmazásban üzenetek közvetítése. 
18. Memento Tervezési Minta:
    Célja, hogy egy objektum belső állapotát tárolja és helyreállítsa később. Pl: Undo/Redo műveletek kezelése.

