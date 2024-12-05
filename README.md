Gruppuppgift: Den gula boken

Grupp 5: 
⦁	Anton Lindström.
⦁	Ahmad Sameer Feroz.
⦁	Ali Asheer.
⦁	Jacob Söder.

Beskrivning av programmet med krav Programmet är en telefonbok med sk CRUD-operationer:
 Create - att lägga till nya profiler i telefonboken
 Read - att söka efter profiler i telefonboken givet olika sökningar
 Update - att kunna uppdatera en profils kontaktuppgifter 
 Delete - att kunna ta bort en profil

Olika användare 
Default så är alla användare i systemet en gäst användare, men då inte alla ska kunna ta bort en användare så behöver användaren logga in som en administratör för att kunna ta bort andras profiler. Detta gäller även för uppdateringen av användarens kontaktinformation.

Kontaktinformation
Varje profil i telefonboken ska ha egenskaperna:
 ⦁ förnamn
 ⦁ efternamn
 ⦁ ålder
 ⦁ adress (med stad, postkod, gatunamn, portnummer)
 ⦁ telefonummer (en profil kan ha flera telefonnummer)

Sökbarhet
 ⦁ Sökning på efternamn - ger profilen som först matchar med sökningen.
 ⦁ Sökning på adress - ger alla profiler på samma gatunamn.
 ⦁ Sökning på förnamn - ger alla profiler med det sökta förnamnet.
 ⦁ Frisökning - ger alla profiler med någon relaterbar kontaktinformation.
 Frisökning avser att söka över samtliga egenskaper. Exempelvis så kan sökningen Erik ge svar på förnamnet Erik, efternamn Eriksson samt adressen Eriksberg.

Krav för uppgiften
 Ett konsolprogram som kan användas av två olika användarprofiler. Gästanvändare och administratör. De två användarprofilerna ska kunna utföra följande:

Gästanvändare
 ⦁ Förmåga att söka efter profiler givet beskrivningen av sökbarhet.
 ⦁ Förmåga att avsluta programmet genom att skriva “quit” i konsolen.

Administratör
 ⦁ Förmåga att lägga till kontaktinformation om en profil med egenskaperna som beskrivs under kontaktinformation.
 ⦁ Förmåga att ta bort kontaktinformation för någon tillagd profil.
 ⦁ Förmåga att uppdatera kontaktinformation för någon tillagd profil.
 ⦁ Samma övriga rättigheter som en gästanvändare.
