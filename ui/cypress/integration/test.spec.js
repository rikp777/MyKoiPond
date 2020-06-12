describe('Breed functionality', () => {
    it('Go to next page', () => {
        cy.visit('http://127.0.0.1:8080/breed')
        cy.get('.page-link').children()
    })
    it('Button click update Breed', () => {
        cy.visit('http://127.0.0.1:8080/breed')
        cy.get('#update-Shusui').click()
        cy.get('#name-input')
        cy.contains('Shusui')
    })
    it('Back from Update to Create', () => {
        cy.visit('http://127.0.0.1:8080/breed')
        cy.get('#reset').click()
        cy.get('.card-title')
        cy.contains('create')
    })
    it('Button click Delete to delete component', () => {
        cy.visit('http://127.0.0.1:8080/breed')
        cy.get('#delete-Shusui').click()
        cy.get('.card-title')
        cy.contains('delete')
    })
})
