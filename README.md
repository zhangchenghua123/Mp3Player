# Introduction

&nbsp;&nbsp;&nbsp;&nbsp;A little assignment to practice finding data, munging it, and analyzing it in a spreadsheet program.

# Dataset details

&nbsp;&nbsp;&nbsp;&nbsp;The dataset I'm working with is "NYC City Owned and Leased Properties(COLP)", which is available as a geodatabase. It is a list of uses on city owned and leased properties that includes geographic information as well as the type of use, agency and other related information. The dataset is updated biannually.COLP is produced from an extract of the Integrated Property Information System (IPIS), a real estate database maintained by the Department of Citywide Administrative Services (DCAS). Except where indicated, the data provided is from IPIS. The dataset is available for download on the NYC department of city planning's[Bytes of the big Apple](https://www1.nyc.gov/site/planning/data-maps/open-data/dwn-colp.pagec).The format of the original data file is **CSV format**.

&nbsp;&nbsp;&nbsp;&nbsp;The first 20 rows in the original data file are:


|uid|BOROUGH|BLOCK|LOT|BBL|MAPBBL|CD|HNUM|SNAME|ADDRESS|PARCELNAME|AGENCY|USECODE|USETYPE|OWNERSHIP|CATEGORY|EXPANDCAT|EXCATDESC|LEASED|FINALCOM|AGREEMENT|XCOORD|YCOORD|LATITUDE|LONGITUDE|DCPEDITED|GEOM|
|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
|0007d535792307f74ea9eb02cad4f9df|3|5053|43|3050530043.00000000|3050530043.00000000||||||NYCTA|0860|TRANSIT FACILITY|C|1|7|"MAINTENANCE| STORAGE| & INFRASTRUCTURE USE"||||994808|177585|40.6541000|-73.9619490||0101000020D70800005D613127F05B2E41D482588E87AD0541|
|000a1ed096033049f35323e03b5d796d|4|7619|1|4076190001.00000000|4076190001.00000000|411|218-12|67 AVENUE|218-12 67 AVENUE|PS 46 AND PLAYGROUND (JOP)|EDUC|0211|ELEMENTARY SCHOOL|C|1|2|EDUCATIONAL USE||||1051294|211064|40.7457450|-73.7580430||0101000020D7080000B2DFC6EA9D0A30415ECC99F8C1C30941|
|000d139fcbd0fe6108aa47a9948c0fa3|3|2467|1|3024670001.00000000|3024670001.00000000|301|390|KENT AVENUE|390 KENT AVENUE|DFMCS CENTRAL REPAIR SHOP|DOT|0940|COMBINED MAINTENANCE/STORAGE FACILITY|C|1|7|"MAINTENANCE| STORAGE| & INFRASTRUCTURE USE"||||992910|198480|40.7114550|-73.9687630||0101000020D70800004F5099DD1B4D2E4116821B44823A0841|
|000d79677d97e61ff74d9c24cec23a92|3|6056|15|3060560015.00000000|3060560015.00000000|310|8602|7 AVENUE|8602 7 AVENUE|FUTURE SCHOOL|SCA|0220|HIGHER EDUCATION|O|1|2|EDUCATIONAL USE||||978210|164590|40.6184360|-74.0217560||0101000020D708000051B8293244DA2D417875505970170441|
|000f496025abaf7316506ebc6c10709a|2|3063|102|2030630102.00000000|2030630102.00000000|206|2132-52|ARTHUR AVENUE|2132-52 ARTHUR AVENUE|QUARRY ROAD BALLFIELDS PARK|PARKS|0432|PLAYING FIELD|C|1|3|CULTURAL & RECREATIONAL USE||||1014643|249191|40.8505950|-73.8901410||0101000020D70800004DB0ADF3E5F62E414C4600D2396B0E41|
|001029f52942b465febbb55247251e89|3|1189|31|3011890031.00000000|3011890031.00000000|309|960|CARROLL STREET|960 CARROLL STREET|TRANSIT POLICE DIST.#32 BMS|NYPD|0912|FACILITIES MAINTENANCE|C|1|7|"MAINTENANCE| STORAGE| & INFRASTRUCTURE USE"||||995480|182626|40.6679360|-73.9595190||0101000020D7080000B95CAE0130612E4148BA21B5104B0641|
|00232793be31550fafbc94218774083e|2|2420|170|2024200170.00000000|2024200170.00000000|204||||MORRISANIA AIR RIGHTS|NYCHA|0872|MUNICIPAL PARKING - OUTDOOR|O|1|7|"MAINTENANCE| STORAGE| & INFRASTRUCTURE USE"||||1007160|239710|40.8245950|-73.9172210||0101000020D7080000FFCD124270BC2E41F1CE65CFF1420D41|
|002333354994f7915dee9c6ed10393e2|2|2911|1|2029110001.00000000|2029110001.00000000|203|1420|WASHINGTON AVENUE|1420 WASHINGTON AVENUE|MORRIS HOUSES AND PLAYGROUND|NYCHA|0431|PLAYGROUND|O|1|3|CULTURAL & RECREATIONAL USE||||1010999|243993|40.8363400|-73.9033330||0101000020D7080000DB48052B6EDA2E4172026B5ECAC80D41|
|0024c2d8fa0e8dd09d770aefbd0406d8|2|3637|1|2036370001.00000000|2036370001.00000000|209|1790|STORY AVENUE|1790 STORY AVENUE|JAMES MONROE HOUSES AND SENIOR CENTER|NYCHA|1410|IN USE-RESIDENTIAL STRUCTURE|O|2|9|PROPERTY WITH RESIDENTIAL USE||||1021627|238894|40.8223060|-73.8649540||0101000020D70800002A85EBE8752D2F41D1F584F971290D41|
|00327943241b8dcde5b29b0e404029a1|1|1081|26|1010810026.00000000|1010810026.00000000|104|505|WEST   52 STREET|505 WEST   52 STREET|OASIS GARDEN|PARKS|0472|COMMUNITY GARDEN|C|1|3|CULTURAL & RECREATIONAL USE||||986680|218464|40.7663100|-73.9912280||0101000020D7080000D8B2BBC66F1C2E412301A43002AB0A41|
|0035c6926dcea153d3b35cca5168f003|4|16103|140|4161030140.00000000|4161030140.00000000|414||BEACH   80 STREET|BEACH   80 STREET||DSBS|1500|NO USE|C|3|8|PROPERTY WITH NO USE||||1037623|155091|40.5922050|-73.8078230||0101000020D7080000BE6D603A6EAA2F41D7852EAE99EE0241|
|003b68c6ffb6883c91109e5dcb7c4f6d|4|3490|1|4034900001.00000000|4034900001.00000000|405|66-56|FOREST AVENUE|66-56 FOREST AVENUE|IS 93 AND PLAYGROUND|PARKS|0430|PLAYGROUND/SPORTS AREA|C|1|3|CULTURAL & RECREATIONAL USE||||1011140|196386|40.7056700|-73.9030140||0101000020D708000090CDA52188DB2E411C4AA1CD0FF90741|
|00416124df5fb3300d288c751de416e4|5|9|6|5000090006.00000000|5000090006.00000000|501||STUYVESANT PLACE|STUYVESANT PLACE|ST GEORGE PARK|PARKS|0411|NEIGHBORHOOD SITTING AREA|C|1|3|CULTURAL & RECREATIONAL USE||||962641|174111|40.6445450|-74.0778670||0101000020D7080000A7AFB508A2602D41F258BCD9F8400541|
|0048a191a309fa8bc000de8442dd40d5|1|3|3|1000030003.00000000|1000030003.00000000|101||WHITEHALL STREET|WHITEHALL STREET|PETER MINUIT PLAZA/BATTERY PARK|PARKS|0440|PARK|C|1|3|CULTURAL & RECREATIONAL USE||||980605|195017|40.7019530|-74.0131460||0101000020D70800006C6231F2F9EC2D4157172C3049CE0741|
|0053cf84cf1fce55bfda5a784bc3b754|5|3748|53|5037480053.00000000|5037480053.00000000|502||DONGAN HILLS AVENUE|DONGAN HILLS AVENUE|NEW CREEK BLUEBELT|DEP|0471|NATURAL AREA/WETLAND/WILDLIFE REFUGE|C|1|3|CULTURAL & RECREATIONAL USE||||960779|150635|40.5801040|-74.0844950||0101000020D70800006C9D250D16522D413310D5465A630241|
|0057636d3ff9b6556ddf84452f292ffe|3|1754|26|3017540026.00000000|3017540026.00000000|303||MYRTLE AVENUE|MYRTLE AVENUE||HPD|1520|NO USE-VACANT LAND|C|3|8|PROPERTY WITH NO USE||D||997881|192468|40.6949470|-73.9508440||0101000020D7080000BD1DF318F2732E412969CDA5A17E0741|
|0058f45bbb9789fac946d09b7d1782a5|5|5226|20|5052260020.00000000|5052260020.00000000|503||RAMBLEWOOD AVENUE|RAMBLEWOOD AVENUE||DEP|0471|NATURAL AREA/WETLAND/WILDLIFE REFUGE|P|1|3|CULTURAL & RECREATIONAL USE||||940981|138446|40.5465730|-74.1556890||0101000020D7080000DBBA0E336AB72C413F73810A72E60041|
|00592c15ce0e778f06913f82541a9b80|3|25|12|3000250012.00000000|3000250012.00000000|302|11|WATER STREET|11 WATER STREET|UNDER BROOKLYN BRIDGE|DOT|0880|ROAD/HIGHWAY|C|1|7|"MAINTENANCE| STORAGE| & INFRASTRUCTURE USE"||||985923|195722|40.7038890|-73.9939660||0101000020D708000001E1A20786162E415754C23352E40741|
|005ab5201d6004a37d4a4f284f1b81c3|1|323|2|1003230002.00000000|1003230002.00000000|103|326|DELANCEY STREET|326 DELANCEY STREET|PUBLIC BATH HOUSE|PARKS|0440|PARK|C|1|3|CULTURAL & RECREATIONAL USE||||990598|200443|40.7168440|-73.9771000||0101000020D708000059F0CF400C3B2E4137398390D7770841|
|005b1079b39260a95463339eb5f05cb3|2|2302|12|2023020012.00000000|2023020012.00000000|201|383|EAST  140 STREET|383 EAST  140 STREET|PS 49 PLAYGROUND (JOP)|EDUC|0430|PLAYGROUND/SPORTS AREA|C|1|3|CULTURAL & RECREATIONAL USE||||1005456|234669|40.8107630|-73.9233940||0101000020D7080000F0BCA02920AF2E4129D7136D69A50C41|

&nbsp;&nbsp;&nbsp;&nbsp;In this dataset, the most obvious problem is that in some rows, some necessary fields do not have data, such as the field "CD", which consists of three digits, the first of which is the borough code. The second and third digits are the community district or joint interest area  number. This field is empty in the second row of the dataset. Other fields such as "EXPANDCAT" have the same problem.

&nbsp;&nbsp;&nbsp;&nbsp;In the data cleaning task, to solve this problem, I first looked at the documentation of the data set to understand the meaning of the individual fields and the data type, where the data type might be Integer, float, text, such as the field "CD" meaning, as described above, the data type is INTEGER.First I define a list in the program: field_types. Each element in the list is a triplet. Each triplet contains the name of the field, the data type of the field, and whether the column in which the field is located is removed during data cleaning, with 0 indicating no removal and 1 indicating removal.

```
field_types=[('uid',        str,    0),
             ('BOROUGH',    str,    0),
             ('BLOCK',      int,    0),
             ('LOT',        int,    0),
             ('BBL',        float,  0),
             ('MAPBBL',     float,  0),
             ('CD',         int,    0),
             ('HNUM',       str,    0),
             ('SNAME',      str,    1),
             ('ADDRESS',    str,    1),
             ('PARCELNAME', str,    1),
             ('AGENCY',     str,    1),
             ('USECODE',    str,    1),
             ('USETYPE',    str,    1),
             ('OWNERSHIP',  str,    1),
             ('CATEGORY',   int,    0),
             ('EXPANDCAT',  int,    0),
             ('EXCATDESC',  str,    1),
             ('LEASED',     str,    1),
             ('FINALCOM',   str,    1),
             ('AGREEMENT',  str,    1),
             ('XCOORD',     int,    0),
             ('YCOORD',     int,    0),
             ('LATITUDE',   float,  0),
             ('LONGITUDE',  float,  0),
             ('DCPEDITED',  str,    1),
             ('GEOM',       str,    1)]
```

We generally believe that a field whose data type is INTEGER or float cannot have empty content, that is, there must be data. So in the code, all the fields in a row are evaluated. If the content is empty and the data type is int or float, then the row is incomplete and needs to be cleaned up.


```
	def is_number(s):
    	try:
    	    if '.' in s:
    	        float(s)
    	    else:
    	        int(s)
    	    return True
    	except ValueError:
    	    pass
    	return False


	def verify(dic):
    	for key,conversion,_ in field_types:
    	    if conversion in [int,float] and not is_number(dic[key]):
    	        return False
    	return True
```


```
def has_empty_field(dic):
    for key,conversion,_ in field_types:
        if dic[key]=='' and conversion in [int,float]:
            return True
    return False


data=[]
with open('data/colp_202206.csv') as f:
    # print(type(csv.DictReader(f)),len(csv.DictReader(f)))
    for i,row in enumerate(csv.DictReader(f)):
        if has_empty_field(row):
            continue
        for key,conversion,to_delete in field_types:
            if to_delete==1:
                row.pop(key)
            else:
                row.update({key:conversion(row[key])})
        data.append(row)
```

The original dataset had 17,202 records, and after data cleaning, there were 17,119 records

# Analisys

In this work,four different aggregate statistics are `MAX`, `MIN`,`COUNTIF`, and `MODE.SNGL`.`MIN` and `MAX` are used to calculate the minimun and maximum of the LATITUDE field, and the calculated results are 40.49617 and 40.90981, respectively. `COUNTIF` is used to count the number of possible values(1, 2, and 3) of the CATEGORY field. The result is:

|value|desc|command|count|
|-|-|-|-|
|1|Non-residential properties with a current use|COUNTIF(I2:I17120,"=1")|12390|
|2|Residential properties|COUNTIF(I2:I17120,"=2")|1279|
|3|Properties with no current use|COUNTIF(I2:I17120,"=3")|3450|

we can find that the Non-residential properties with a current use is the majority.

`MODE.SNGL` can also help us find the most frequent numbers in an area. The EXPANDCAT field 
means expanded caterory. It's valid values are 1-9:

|value|disc|
|-|-|
|1|Office use|
|2|Educational use|
|3|Cultural & recreational use|
|4|Public safety & criminal justice use|
|5|Health & social service use|
|6|Leased out to a private tenant|
|7|Maintenance, storage & infrastructure|
|8|Property with no use|
|9|Property with a residential used|

when using `MODE.SNGL` on this field,we get 3,which means Cultural & recreational using is the majority in these categories.
