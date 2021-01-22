*Mögliche Fehler*

Obwohl unsere Implementierung bereits alle uns bekannten Fälle von eBay-Angebots-Titel behandelt und versucht nur sinnvolle
Titel für die Weiterverarbeitung zu verwenden, könnte zukünftig ein uns noch unbekannter Fall auftreten. 
Falls der ramListService dann einen Fehler wirft, könnte folgende Fehlerursache(n) bestehen.

- Der eBay-Verkäufer hat für sein Angebot einen Titel verwendet, welcher unsere String-Überprüfung passiert, obwohl dieser für die
Weiterverarbeitung nicht geeignet ist und verursacht dadurch einen Fehler. 

Die Implementierung hat an kritischen Stellen einen System.out.println(), dadurch lässt sich anhand der Konsole oft schon sehr
schnell erkennen, welche Strings zur Weiterverarbeitung verwendet wurden und an welcher Stelle der Fehler liegen könnte.

*Lösung*

- Unser Programm, unsere API zu einem späteren Zeitpunkt nochmals probieren, wenn das eBay-Angebot mit dem kritischen Titel
ausgelaufen ist

- Andere query params verwenden (z.B. ramCapacity = x oder budget = y ...), um andere eBay-Angebote 
welche dann nicht-kritische Titel haben, zu erhalten, die dann problemlos von der Implementierung weiterverarbeitet werden können