--"Результаты соревнований": соревнование – спортсмен – тренер – результат – занятое место.
результат – занятое место.
create view competition_result as
(
select competition_id, sportsmen_certificate_id, trainer_id, result, place
from sportsmen_competition
         inner join sportsmen s on sportsmen_competition.sportsmen_certificate_id = s.certificate_id
    );

--"Спортсмены, не участвующие в соревнованиях".
create view no_experience_sportsmen as
(
select *
from sportsmen s
where not exists(select 1 from sportsmen_competition where sportsmen_certificate_id = s.certificate_id)
    );

/*"Рейтинги тренеров". Рейтинг рассчитать как отношение количества спортсменов, занявших в соревнованиях первые три места, к общему количеству
спортсменов данного тренера.
спортсменов, занявших в соревнованиях первые три места, к общему количеству
спортсменов данного тренера.*/
create view trainer_rating as
(
select t.id,
       t.fio,
       round(sum(case when sc.place <= 3 then 1 else 0 end) * 100 / count(distinct s.certificate_id), 2) / 100 rating
from trainer t
         inner join sportsmen s on t.id = s.trainer_id
         left join sportsmen_competition sc on s.certificate_id = sc.sportsmen_certificate_id
group by t.id
    );