#include <stdio.h>

int main()
{
    int c;
    char content[255];
    char filename[255];
    FILE *file;
    printf("Introduzca el nombre de archivo: ");
    scanf("%s", filename);
    file = fopen(filename, "r");
    while ((c = fgetc(file)) != EOF)
    {
        fputc(c, stdout);
    }
    fclose(file);
}