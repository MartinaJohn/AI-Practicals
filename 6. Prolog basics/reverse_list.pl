reverse([], []).
reverse([H|T], Reversed) :- reverse(T, Result), append(Result, [H], Reversed).
