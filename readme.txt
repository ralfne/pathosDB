This query retrieves a genbank record for an accesion number:
http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=nucleotide&id=U43746&rettype=gb&retmode=text


To get taxID for tax name (xml result):
http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=Taxonomy&term=Homo sapiens

To get records for Tax ID (xml result):
http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=nucleotide&term=txid9606[Organism]&RetMax=100

Gets the gi numbers for results. Giving gi numbers in the first query does not always work?!?

This works (with gi numbers):

http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=nucleotide&id=576584137&rettype=gb&retmode=text

http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=nucleotide&id=90970320&rettype=gb&retmode=text


Downloading fasta files:

http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=nucleotide&id=576584137&rettype=fasta&retmode=text



