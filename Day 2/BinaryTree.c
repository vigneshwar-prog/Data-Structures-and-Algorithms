#include <stdio.h>
#include <stdlib.h>


struct node{
    struct node* left;
    int data;
    struct node* right;
};

struct node* root = NULL;

struct node* creatnode(int data){
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    temp -> data = data;
    temp->left = temp->right = NULL;
    return temp;
}


void insert(struct node* tt,int val){
    if(tt == NULL){
        root = creatnode(val);
        return;
    }
    if(val < tt -> data){
        if(tt->left != NULL){
            insert(tt->left , val);
        }
        else{
            tt->left = creatnode(val);
        }
    }
    else if (val > tt->data){
        if(tt -> right != NULL){
            insert(tt->right,val);
        }
        else{
            tt->right = creatnode(val);
        }
    }
}

void preOrder(struct node* head){
    if(head){
        printf("%d ",head -> data);
        preOrder(head->left);
        preOrder(head->right);
    }
}

void inOrder(struct node* head){
    if(head){
        inOrder(head->left);
        printf("%d ",head->data);
        inOrder(head -> right);
    }
}

void postOrder(struct node* head){
    if(head){
        postOrder(head->left);
        postOrder(head->right);
        printf("%d ",head -> data);
    }
}

int main(){
    int n,num;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d ",&num);
        insert(root,num);
    }
    preOrder(root);
    printf("\n\n--------------------------------------\n\n");
    inOrder(root);
    printf("\n\n--------------------------------------\n\n");
    postOrder(root);
}