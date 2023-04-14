smallest([X], X).
smallest([H|T], X) :-
    smallest(T, X1),
    (H < X1 -> X = H ; X = X1).