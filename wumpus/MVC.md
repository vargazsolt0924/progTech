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