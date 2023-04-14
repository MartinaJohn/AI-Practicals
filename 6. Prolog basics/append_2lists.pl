append([], L, L).
append([H|T], L, [H|Result]) :- append(T, L, Result).