from decimal import Decimal
import math

Radio = Decimal('6371')
latitud1 = math.radians(Decimal('8.53687'))
latitud2 = math.radians(Decimal('18.53687'))
longitud1 = math.radians(Decimal('-3.5227'))
longitud2 = math.radians(Decimal('5.5227'))

a = math.sin((latitud2-latitud1)/2)**2+math.cos(latitud1)*math.cos(latitud2)*math.sin((longitud2-longitud1)/2)**2
c = 2 *math.atan2(math.sqrt(a),math.sqrt(1-a))

d = Radio*Decimal(c)

print(d)


