CREATE TABLE Client (
                        id INTEGER NOT NULL DEFAULT 0,
                        nom VARCHAR (50),
                        prenom VARCHAR (50),
                        PRIMARY KEY (id)
);
CREATE TABLE Commande (
                          numero INTEGER NOT NULL DEFAULT 0,
                          description VARCHAR (50),
                          montant DOUBLE,
                          id_client SMALLINT,
                          PRIMARY KEY (numero)
);
INSERT INTO Client (id, prenom, nom)
VALUES (10, 'Jake', 'Roberts'),
       (20, 'Brutus', 'Barber'),
       (30, 'Randy', 'Macho'),
       (40, 'Ricky', 'Dragon'),
       (50, 'George', 'Animal'),
       (60, 'Koko', 'Birdman'),
       (70, 'Greg', 'Hammer'),
       (80, 'Bobby', 'Brain');
INSERT INTO Commande (numero, description, montant, id_client)
VALUES (100, 'Contrat d''achat clavier et souris x30', 134.45, 10),
       (101, 'Ultrabook x10', 8332.99, 10),
       (200, 'Kit montage tableau électrique x2', 32.99, 20);