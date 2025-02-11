set terminal pdf
set output 'report.pdf'

set title ""

set xlabel "n"
set ylabel "time in ns"

plot "rnd.dat" u 1:2 with lines title "run-time rnd(n)"