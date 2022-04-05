--create tables
create table trainer
(
    id      numeric(3) primary key,
    fio     varchar(40) not null,
    mastery varchar     not null,
    rating  numeric(4) unique,
    check ( fio ~ '(\w{3,}\040){2}\w{3,}'),
    check ( mastery in ('МС', 'ЧМ') )
);

create table sportsmen
(
    certificate_id numeric(6) primary key,
    fio            varchar(40) not null,
    birthday       date        not null,
    male           char        not null,
    mastery        varchar     not null,
    trainer_id     numeric references trainer (id),
    rating         numeric(4) unique,
    scholarship    numeric(7, 2) default 0,
    address        varchar(40) not null,
    mobile_number  varchar(15),
    home_number    varchar(9),
    check ( fio ~ '(\w{3,}\040){2}\w{3,}'),
    check ( male = 'м' or male = 'ж'),
    check ( mastery in ('1 разряд', '2 разряд', 'КМС', 'МС', 'ЧМ') ),
    check ( mobile_number ~ '\d(-\d{3}){2}(-\d{2}){2}' or null),
    check ( home_number ~ '(-\d{3})(-\d{2}){2}' or null)
);

create table competition
(
    id       numeric primary key,
    type     varchar,
    place    varchar,
    time     date,
    min_year numeric(2)
);

create table sportsmen_competition
(
    id                       numeric primary key,
    competition_id           numeric references competition (id),
    sportsmen_certificate_id numeric references sportsmen (certificate_id),
    result                   numeric not null,
    place                    numeric,
    check ( place > 0 ),
    check ( result >= 0 )
);

insert into trainer (id, fio, mastery, rating)
values (1, 'Доменко Владимир Петрович', 'ЧМ', 1);
insert into trainer (id, fio, mastery, rating)
values (2, 'Неменко Алиса Петрова', 'МС', 2);
insert into trainer (id, fio, mastery, rating)
values (3, 'Даринов Дмитрий Евгеньевич', 'МС', 3);
insert into trainer (id, fio, mastery, rating)
values (4, 'Черпакова Мария Алексеевна', 'ЧМ', 5);
insert into trainer (id, fio, mastery, rating)
values (5, 'Замаев Владислав Витальевич', 'МС', 6);


insert into sportsmen (certificate_id, fio, birthday, male, mastery, trainer_id, rating, scholarship, address,
                       mobile_number, home_number)
values (1, 'Руденко Иван Петрович', to_date('11.10.1990', 'dd.mm.yyyy'), 'м', '1 разряд', 1, 25, 0, ' ',
        '8-905-567-72-11', '495-52-12');
insert into sportsmen (certificate_id, fio, birthday, male, mastery, trainer_id, rating, scholarship, address,
                       mobile_number, home_number)
values (2, 'Клюшин Михали Юрьевич', to_date('12.05.1999', 'dd.mm.yyyy'), 'м', '2 разряд', 2, 10, 200, ' ',
        '8-905-532-71-12', null);
insert into sportsmen (certificate_id, fio, birthday, male, mastery, trainer_id, rating, scholarship, address,
                       mobile_number, home_number)
values (3, 'Сидоров Иван Иванович', to_date('01.01.1985', 'dd.mm.yyyy'), 'м', 'КМС', 3, 4, 5500, ' ', '8-905-537-51-12',
        null);
insert into sportsmen (certificate_id, fio, birthday, male, mastery, trainer_id, rating, scholarship, address,
                       mobile_number, home_number)
values (4, 'Кандратьев Петр Иванович', to_date('25.05.2005', 'dd.mm.yyyy'), 'м', '1 разряд', 4, 43, 500, ' ',
        '8-905-554-51-32', null);
insert into sportsmen (certificate_id, fio, birthday, male, mastery, trainer_id, rating, scholarship, address,
                       mobile_number, home_number)
values (5, 'Ануфриева Людмила Алексеевна', to_date('21.03.2000', 'dd.mm.yyyy'), 'ж', '1 разряд', 4, 54, 500, ' ',
        '8-905-557-75-21', '321-52-12');

insert into competition (id, type, place, time, min_year)
values (1, 'региональные', ' ', to_date('28.09.2019', 'dd.mm.yyyy'), 13);
insert into competition (id, type, place, time, min_year)
values (2, 'мировые', ' ', to_date('11.09.2015', 'dd.mm.yyyy'), 10);
insert into competition (id, type, place, time, min_year)
values (3, 'региональные', ' ', to_date('05.01.2018', 'dd.mm.yyyy'), 0);
insert into competition (id, type, place, time, min_year)
values (4, 'региональные', ' ', to_date('26.09.2019', 'dd.mm.yyyy'), 18);
insert into competition (id, type, place, time, min_year)
values (5, 'региональные', ' ', to_date('23.09.2019', 'dd.mm.yyyy'), 0);

insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (1, 1, 1, 1, 5);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (2, 1, 2, 2, 4);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (3, 1, 3, 3, 3);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (4, 1, 4, 4, 2);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (5, 1, 5, 5, 1);

insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (6, 2, 1, 5, 1);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (7, 2, 2, 4, 2);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (8, 2, 3, 3, 3);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (9, 2, 4, 2, 4);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (10, 2, 5, 1, 5);

insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (11, 3, 1, 3, 3);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (12, 3, 2, 2, 4);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (13, 3, 3, 5, 1);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (14, 3, 4, 1, 5);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (15, 3, 5, 4, 2);

insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (16, 4, 1, 3, 2);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (17, 4, 2, 5, 3);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (18, 4, 3, 2, 4);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (19, 4, 5, 1, 5);

insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (20, 5, 1, 2, 4);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (21, 5, 2, 1, 5);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (22, 5, 3, 5, 1);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (23, 5, 4, 4, 2);
insert into sportsmen_competition (id, competition_id, sportsmen_certificate_id, result, place)
values (24, 5, 5, 3, 3);