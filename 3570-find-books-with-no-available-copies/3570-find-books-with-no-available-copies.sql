# Write your MySQL query statement below
select l.book_id,l.title,l.author,l.genre,l.publication_year,count(*) as current_borrowers from library_books l
join borrowing_records b on 
b.book_id = l.book_id
WHERE b.return_date IS NULL
group by l.book_id,l.title,l.author,l.genre,l.publication_year,l.total_copies
having count(*)=l.total_copies
order by current_borrowers desc ,l.title asc;