insert into authors (name, email,address) values 
('victor hugo', 'victor@email', 'france'),
('mark twain', 'mark@email', 'the usa'),
('fyodor dostoyevski', 'fyodor@email', 'russia'),
('sabahattin ali', 'sabahattin@email', 'turkey'),
('orhan pamuk', 'orhan@email', 'turkey');

insert into publishers (name, email, address) values
('can', 'can@email','turkey'),
('dogan', 'dogan@email', 'turkey'),
('metis', 'metis@email', 'turkey');


insert into books (name, description, isbn, author_id, publisher_id ) values
('miserables', 'the novel elaborates upon the history of France, the architecture and urban design of Paris, politics, moral philosophy, antimonarchism, justice, religion, and the types and nature of romantic and familial love.',
'1234',1,1),
('tom sawyer', 'adventures of tom sawyer', '234',2,3 ),
('crime and punishment', 'Crime and Punishment focuses on the mental anguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint Petersburg who formulates a plan to kill an unscrupulous pawnbroker for her money.',
'345',3,2),
('kuyucaklı yusuf','life of yusuf','456',4,2),
('kar','a story from kars','567',5,1);
