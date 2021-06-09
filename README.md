Budget Flight - jednostavna aplikacija za pretragu letova

Funkcionalnosti:
1. Pretraga ponude letova se vrši na temelju parametara:
	- IATA šifra polaznog aerodroma (tri slova)
	- IATA šifra odredišnog aerodroma (tri slova)
	- datuma polaska
	- datuma povratka (neobavezno)
	- broj putnika (1 do 9)
	- valuti (HRK, EUR, USD)
2. Rezultat pretrage je tablica (server-side paginacija) s ponudom letova:
	- IATA šifra polaznog aerodroma
	- IATA šifra odredišnog aerodroma
	- datum polaska
	- datum povratka (ako ne postoji onda "/")
	- odlazna i povratna ruta
	- broj presjedanja na odlasku i povratku
	- broj putnika (od ukupnog broja slobodnih mjesta)
	- cijena ponude
	- valuta ponude
	- gumb za detalje
3. Stranica s detaljima nudi prikaz dodatnih parametara kao što su:
	- nehomogeni let (YES/NO)
	- trenutna kupovina obavezna (YES/NO)
	- jedan smjer (YES/NO)
	- zadnji datum za kupovinu

Korištene tehnologije:
Java 11
React 16
Spring Boot 2.4.1
In-memory H2 baza podataka
Logiranje exceptiona
Jednostavni Unit testovi

INSTALACIJA
Naredba za pokretanje iz isporuke:
"java -jar budgetflight-0.0.1.jar"
-> logovi se nalaze u "~/logs/spring-boot-logger.log" 

Upute za pokretanje iz razvojnog okruženja:
1. Pokrenuti "budgetflight" kao Spring Boot App (Run As > Spring Boot App) (pokreće se na portu 8443)
2. (DODATNO) Otvoriti terminal nad direktorijem "src/main/webapp" te izvršiti sljedeće naredbe (pokreće se na portu 3000):
	2.1. "yarn install"
	2.2. "yarn start"

Maven naredba za pokretanje testova i kreiranje isporuke
"clean package"
-> isporuka se nalazi u direktoriju target



