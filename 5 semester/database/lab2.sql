--спортсмены с их тренерами
select *
from sportsmen s
         inner join trainer t on s.trainer_id = t.id;

select *
from sportsmen s
         cross join trainer t on s.trainer_id = t.id;

select *
from sportsmen
    except
select *
from (
         select *
         from sportsmen
         where not home_number is null
         union
         select *
         from sportsmen
         where not mobile_number is null
) with_number;

--спортсмены подходящие для участия в определенных соревнованиях
select *
from sportsmen s
where exists(select 1
             from competition c
             where c.id in (1) -- id of competitions
               and extract(year from current_date) - extract(year from s.birthday) >= c.min_year);

--спортсмены, участвовавшиe в соревнованиях текущего года (упорядоченные по соревнованию и количеству завоеванных очков);
select distinct *
from (
         select sportsmen.*
         from sportsmen
                  inner join sportsmen_competition sc on sportsmen.certificate_id = sc.sportsmen_certificate_id
                  inner join competition c on sc.competition_id = c.id
         where extract(year from c.time) = extract(year from current_date)
         order by competition_id, sc.result) sp_cr_y;

--спортсмены, у которых не указан ни домашний, ни мобильный телефон.
select distinct *
from sportsmen
where home_number is null
  and mobile_number is null;

--Вывести для каждого соревнования количество участников.
select competition_id, count(*) spotrsmens_count
from competition
         inner join sportsmen_competition sc on competition.id = sc.competition_id
group by competition_id;