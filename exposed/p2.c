#include <stdio.h>
#include <stdlib.h>
typedef struct Element{
   struct Element *next;
   void *data;
} Element;
//PROBLEM: head and tail are global pointers to the first and last element, 
//of a singly linked list of integers. Implement C functions for the following 
//prototypes.

int delete(Element *elem);
int insertAfter(Element *elem, int data);



int printElements();

void* head;
void* tail;

int main(void)
{
   Element* element;
   int number;
   number = 3;

   element = (Element*)malloc(sizeof(Element));
   (int*)element->data = ((int*) malloc(sizeof(int)));
   ((int*)element->data) = number;
   ((Element*) head) = element;
   ((Element*) tail) = element;
   insertAfter(element,5);
   insertAfter(element,4);
   printElements();
   return 0;
}
int printElements()
{
   Element* runner = head;
   while(runner)
   {
      printf("%d\n",(int) runner->data);
      runner = runner->next;
   }
   return 0;
}
int delete(Element *elem)
{
   return 0;
}
/**
 * Insert a new node after the specified one, update head and tail.
 * @param elem is the element after which the new element should be inserted.
 * @param data is the data for the new element.
 */
int insertAfter(Element *elem, int data)
{
   //check if the specified node is null
   if(!elem)
   {
      return 0;
   }
   Element* temp = head;
   while(temp)
   {
      if(temp == elem)
      {
	 Element* next = (Element*) malloc(sizeof(Element));
	 next -> next =  elem -> next;
	 ((int*)(next->data)) = (int*) malloc(sizeof(int));
	 next -> data = data;
	 temp -> next = next;
	 if(next -> next == NULL)
	 {
	    tail = next;
	 }
	break; 

      }
      else
      {
	 temp = temp -> next;
      }

   }
   return 1;
}
